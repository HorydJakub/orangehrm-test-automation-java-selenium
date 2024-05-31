package com.jakubhoryd.enums;

public enum NavmenuOption {

    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFORMANCE("Performance"),
    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    CLAIM("Claim"),
    BUZZ("Buzz");

    private final String option;

    NavmenuOption(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
