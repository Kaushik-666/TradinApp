package com.kaushik.utility;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.kaushik.exception.TradeException;
import com.kaushik.model.Trade;

public class TradeUtility {

	private static Map<Integer, Trade> tradeMap = new HashMap<>();

	public static void addTrade(Trade trade) {
		if (tradeMap.containsKey(trade.getTradeId())) {
			try {
				validateVersion(trade, tradeMap.get(trade.getTradeId()));
				addOrRejectTrade(trade, "updated");
			} catch (TradeException e) {
				System.out.println(e.getMessage());
			}
		} else {
			addOrRejectTrade(trade, "added");
		}
	}

	private static void addOrRejectTrade(Trade trade, String operation) {
		if (validateMaturityDate(trade.getCreatedDate(), trade.getMaturityDate())) {
			tradeMap.put(trade.getTradeId(), trade);
			System.out.println(trade + operation + " successfully");
		} else {
			System.out.println("Could not add trade " + trade + " as maturity date: " + trade.getMaturityDate()
					+ " is before current date: " + trade.getCreatedDate());
		}
	}

	private static void validateVersion(Trade newTrade, Trade existingTrade) throws TradeException {
		if (newTrade.getVersion() < existingTrade.getVersion()) {
			throw new TradeException("Version of new trade " + newTrade + " is less than the version of existing trade "
					+ existingTrade);
		}
	}

	private static boolean validateMaturityDate(LocalDate createdDate, LocalDate maturityDate) {
		return (createdDate.isBefore(maturityDate) || createdDate.isEqual(maturityDate));
	}

	public static void printAllTrade() {
		System.out.println("The trades in store are: ");
		tradeMap.forEach((K, V) -> {
			System.out.println(V);
		});
	}

	public static void updateExpiredFlag() {
		tradeMap.forEach((K, V) -> {
			if (LocalDate.now().isAfter(V.getMaturityDate())) {
				V.setExpired('Y');
			}
		});
	}
}
