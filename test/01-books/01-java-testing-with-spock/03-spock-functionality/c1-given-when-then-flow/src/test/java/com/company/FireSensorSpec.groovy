package com.company

import spock.lang.Specification

class FireSensorSpec extends Specification {

    def "If all sensors are inactive everything is OK"(){ // Clear explanation of what this test does

        given: "that all fire sensors are off" // Setup phase
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning()
        int triggeredSensors = 0

        when: "we ask the status of fire control" // Stimulus phase
        fireEarlyWarning.feedData(triggeredSensors)
        WarningStatus status = fireEarlyWarning.getCurrentStatus()

        then: "no alarm/notification should be triggered" // Assert phase
        !status.alarmActive
        !status.fireDepartmentNotified
    }

    def "If one sensor is active the alarm should sound as a precaution"(){
        given: "that only one fire sensor is active"
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning()
        int triggeredSensors = 1

        when: "we ask the status of fire control"
        fireEarlyWarning.feedData(triggeredSensors)
        WarningStatus status = fireEarlyWarning.getCurrentStatus()

        then: "only the alarm should be triggered"
        status.alarmActive
        !status.fireDepartmentNotified
    }

    def "If more than one sensor is active then we have a fire"(){
        given: "that two fire sensors are active"
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning()
        int triggeredSensors = 2

        when: "we ask the status of fire control"
        fireEarlyWarning.feedData(triggeredSensors)
        WarningStatus status = fireEarlyWarning.getCurrentStatus()

        then: "alarm is triggered and the fire department is notified"
        status.alarmActive
        status.fireDepartmentNotified
    }
}
