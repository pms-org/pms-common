package com.pms.simulator.constants;

/**
 * Constants used across the simulator domain
 */
public final class SimulatorConstants {

    private SimulatorConstants() {
        // Prevent instantiation
    }

    // Kafka topics
    public static final String TOPIC_SIMULATED_TRADE = "pms.simulator.trade";

    // Metrics
    public static final String METRIC_TRADE_SIMULATED = "pms.simulator.trade.generated";
}
