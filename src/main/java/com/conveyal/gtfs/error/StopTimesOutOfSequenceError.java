package com.conveyal.gtfs.error;

import com.conveyal.gtfs.validator.model.Priority;

import java.io.Serializable;

/**
 * Created by landon on 5/6/16.
 */
public class StopTimesOutOfSequenceError extends GTFSError implements Serializable {
    public static final long serialVersionUID = 1L;

    public final Priority priority = Priority.HIGH;
    public final String tripId;
    public final int stopSequence;
    public final int previousStopSequence;

    public StopTimesOutOfSequenceError(String tripId, int stopSequence, int previousStopSequence) {
        super("stop_times", 0, "trip_id");
        this.tripId = tripId;
        this.stopSequence = stopSequence;
        this.previousStopSequence = previousStopSequence;

    }

    @Override public String getMessage() {
        return "Trip Id " + tripId + " stop sequence " + stopSequence + " arrives before departing " + previousStopSequence;
    }
}
