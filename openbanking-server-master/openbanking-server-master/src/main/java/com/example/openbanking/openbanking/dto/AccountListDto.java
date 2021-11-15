package com.example.openbanking.openbanking.dto;

import java.util.List;
import lombok.Data;

@Data
public class AccountListDto {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String user_name;
	private String res_cnt;
	private List<AccountDto> res_list;
}
