package org.app.services;

public class QueryService {

    String processQuery(String request, int price) {
        return switch (request) {
            case "best_bid" -> InputService.bids.lastEntry().toString().replace("=", ",");
            case "best_ask" -> InputService.asks.firstEntry().toString().replace("=", ",");
            case "size" -> InputService.bids.containsKey(price) ? InputService.bids.get(price).toString() : (InputService.asks.containsKey(price) ?
                    InputService.asks.get(price).toString() : "0");
            default -> null;
        };
    }
}
