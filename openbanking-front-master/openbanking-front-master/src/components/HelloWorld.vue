<template>
  <div>
    <button @click="clearSession">clearSession</button><br/>
    <div class="authBox">
      <h3>사용자 인증</h3>
      <span>code: {{ auth.code }}</span><br/>
      <span>scope: {{ auth.scope }}</span><br/>
      <span>client_info: {{ auth.client_info }}</span><br/>
      <span>state: {{ auth.state }}</span><br/><br/>
      <form method="get" action="https://testapi.openbanking.or.kr/oauth/2.0/authorize" target="_blank">
        <input type="hidden" name="response_type" value="code"/>
        <input type="hidden" name="client_id" value="35081a8f-6c53-40af-b8d4-611f1ee3ba3f"/>
        <input type="hidden" name="redirect_uri" value="http://localhost:8080"/>
        <input type="hidden" name="scope" value="login inquiry transfer"/>
        <input type="hidden" name="state" value="b80BLsfigm9OokPTjy03elbJqRHOfGSY"/>
        <input type="hidden" name="auth_type" value="0"/>
        <input type="submit" value="requestAuth"/>
      </form>
      <button @click="saveAuth">saveAuth</button>
    </div>
    <br/>
    <div class="tokenBox">
      <h3>토큰발급</h3>
      <span>access_token: {{ token.access_token }}</span><br/>
      <span>expires_in: {{ token.expires_in }}</span><br/>
      <span>refresh_token: {{ token.refresh_token }}</span><br/>
      <span>scope: {{ token.scope }}</span><br/>
      <span>token_type: {{ token.token_type }}</span><br/>
      <span>user_seq_no: {{ token.user_seq_no }}</span><br/><br/>
      <button @click="requestToken">requestToken</button>
      <button @click="saveToken">saveToken</button>
    </div>
    <div>
      <h3>계좌리스트 조회</h3>
      <button @click="getAccountList">getAccountList</button>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'HelloWorld',
  mounted: function () {
    this.init()
  },
  data () {
    return {
      auth: {
        code: '',
        scope: '',
        client_info: '',
        state: ''
      },
      token: {
        access_token: '',
        expires_in: '',
        refresh_token: '',
        scope: '',
        token_type: '',
        user_seq_no: ''
      }
    }
  },
  methods: {
    init () {
      if (sessionStorage.auth) {
        this.auth = JSON.parse(sessionStorage.auth)
      }
      if (sessionStorage.token) {
        this.token = JSON.parse(sessionStorage.token)
      }
    },
    clearSession () {
      sessionStorage.auth = ''
      sessionStorage.token = ''
      this.auth = {
        code: '',
        scope: '',
        client_info: '',
        state: ''
      }
      this.token = {
        access_token: '',
        expires_in: '',
        refresh_token: '',
        scope: '',
        token_type: '',
        user_seq_no: ''
      }
    },
    saveAuth () {
      sessionStorage.auth = JSON.stringify({
        code: this.$route.query.code,
        scope: this.$route.query.scope,
        client_info: this.$route.query.client_info,
        state: this.$route.query.state
      })
      this.auth = JSON.parse(sessionStorage.auth)
    },
    requestToken () {
      axios.post('http://localhost:8081/requestToken', {
        code: this.auth.code,
        client_id: '35081a8f-6c53-40af-b8d4-611f1ee3ba3f',
        client_secret: '',
        redirect_uri: 'http://localhost:8080',
        grant_type: 'authorization_code'
      })
        .then((result) => {
          console.log(result)
          this.token = result.data
        })
    },
    saveToken () {
      sessionStorage.token = JSON.stringify({
        access_token: this.token.access_token,
        expires_in: this.token.expires_in,
        refresh_token: this.token.refresh_token,
        scope: this.token.scope,
        token_type: this.token.token_type,
        user_seq_no: this.token.user_seq_no
      })
    },
    getAccountList () {
      axios.get('http://localhost:8081/account/list', {
        params: {access_token: this.token.access_token,
          user_seq_no: this.token.user_seq_no,
          include_cancel_yn: 'Y',
          sort_order: 'D'
        }
      })
        .then((result) => {
          console.log(result)
        })
    }
  }
}
</script>

<style scoped>
  form {
    display: inline-block;
  }

  .authBox {
    display: inline-block;
    padding: 20px;
    width: 400px;
    text-align: left;
    border: 1px solid gray;
  }

  .tokenBox {
    display: inline-block;
    padding: 20px;
    width: 400px;
    text-align: left;
    border: 1px solid gray;
  }
</style>
