package com.example.openbanking.openbanking.dto;

import java.util.List;

import lombok.Data;

@Data
public class AccountTransactionListDto {
	private String api_tran_id;
	private String api_tran_dtm;
	private String rsp_code;
	private String rsp_message;
	private String bank_tran_id;
	private String bank_tran_date;
	private String bank_code_tran;
	private String bank_rsp_code;
	private String bank_rsp_message;
	private String bank_name;
	private String fintech_use_num;
	private String balance_amt;
	private String page_record_cnt;
	private String next_page_yn;
	private String befor_inquiry_trace_info;
	private List<AccountTransactionDto> res_list;
}
