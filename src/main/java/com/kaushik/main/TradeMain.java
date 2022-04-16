package com.kaushik.main;

import java.time.LocalDate;

import com.kaushik.model.Trade;
import com.kaushik.utility.TradeUtility;

public class TradeMain {

	public static void main(String[] args) {
		// Add Trades
		Trade t1 = new Trade(1, 1, "CP_1", "B_1", LocalDate.now(), LocalDate.parse("2022-04-20"), 'N');
		TradeUtility.addTrade(t1);

		Trade t2 = new Trade(2, 0, "CP_2", "B_2", LocalDate.now(), LocalDate.parse("2022-04-21"), 'N');
		TradeUtility.addTrade(t2);

		Trade t3 = new Trade(3, 2, "CP_3", "B_3", LocalDate.now(), LocalDate.parse("2022-04-22"), 'N');
		TradeUtility.addTrade(t3);

		Trade t4 = new Trade(4, 2, "CP_4", "B_4", LocalDate.now(), LocalDate.parse("2022-04-23"), 'N');
		TradeUtility.addTrade(t4);

		System.out.println("Before Update: ");
		TradeUtility.printAllTrade();

		System.out.println();
		// Updating trade with tradeId = 4
		Trade t5 = new Trade(4, 1, "CP_Updated_4", "B_Updated_4", LocalDate.now(), LocalDate.parse("2022-04-24"), 'N');
		TradeUtility.addTrade(t5);

		System.out.println();

		System.out.println("After Update: ");
		TradeUtility.printAllTrade();

		/*
		 * Updating expired date. For this to work comment out the if and else condition
		 * of 'addOrRejectTrade' method in TradeUtility class. Keep the body within the
		 * if condition as it is
		 */
		System.out.println();
		Trade t6 = new Trade(6, 2, "CP_6", "B_6", LocalDate.now(), LocalDate.parse("2022-04-14"), 'N');
		TradeUtility.addTrade(t6);
		System.out.println();
		System.out.println("Before Updating flag");
		TradeUtility.printAllTrade();
		TradeUtility.updateExpiredFlag();

		System.out.println("After updating flag");
		TradeUtility.printAllTrade();
	}

}
