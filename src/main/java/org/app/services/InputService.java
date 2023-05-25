package org.app.services;

import java.util.TreeMap;

public class InputService {
    static TreeMap<Integer, Integer> bids = new TreeMap<>();
    static TreeMap<Integer, Integer> asks = new TreeMap<>();
    private final UpdateService updateService = new UpdateService();
    private final QueryService queryService = new QueryService();
    private final OrderService orderService = new OrderService();

    public String processInput(String input) {
        String[] inputs = input.split(",");
        switch (inputs[0]) {
            case "u" -> {
                updateService.processUpdate(Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]), inputs[3]);
                return null;
            }
            case "q" -> {
                return queryService.processQuery(inputs[1], inputs.length == 3 ? Integer.parseInt(inputs[2]) : 0);
            }
            case "o" -> {
                orderService.processOrder(inputs[1], Integer.parseInt(inputs[2]));
                return null;
            }
        }
        return null;
    }
}
