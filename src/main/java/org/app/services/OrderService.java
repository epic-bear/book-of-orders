package org.app.services;

import java.util.Map;

public class OrderService {

    void processOrder(String request, int size) {
        if (request.equals("sell")) {
            while (size > 0) {
                Map.Entry<Integer, Integer> best = InputService.bids.lastEntry();
                if (best.getValue() > size) {
                    InputService.bids.put(best.getKey(), best.getValue() - size);
                    size = 0;
                } else {
                    size -= best.getValue();
                    InputService.bids.remove(best.getKey());
                }
            }
        }

        if (request.equals("buy")) {
            while (size > 0) {
                Map.Entry<Integer, Integer> best = InputService.asks.firstEntry();
                if (best.getValue() > size) {
                    InputService.asks.put(best.getKey(), best.getValue() - size);
                    size = 0;
                } else {
                    size -= best.getValue();
                    InputService.asks.remove(best.getKey());
                }
            }
        }
    }
}
