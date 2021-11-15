package com.example.openbanking.openbanking.dto;

import lombok.Data;

@Data
public class AccountTransactionDto {
	private String tran_date;
	private String tran_time;
	private String inout_type;
	private String tran_type;
	private String printed_content;
	private String tran_amt;
	private String after_balance_amt;
	private String branch_name;
}
