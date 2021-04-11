package commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Dropdown {
    DEPART_DATE("Date"),
    DEPART_FROM("DepartStation"),
    ARRIVE_AT("ArriveStation"),
    SEAT_TYPE("SeatType"),
    TICKET_AMOUNT("TicketAmount");;

    private final String name;
}
