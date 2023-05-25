package org.app.services;

public class UpdateService {

    void processUpdate(int price, int size, String type) {
        if (type.equals("bid")) {
            if (size == 0) {
                InputService.bids.remove(price);
            } else {
                InputService.bids.put(price, size);
            }
        }
        if (type.equals("ask")) {
            if (size == 0) {
                InputService.asks.remove(price);
            } else {
                InputService.asks.put(price, size);
            }
        }
    }
}
