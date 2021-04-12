package data;

import commons.enums.Dropdown;
import io.cucumber.java.eo.Se;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TicketInfo {
    private int numOrder;
    private String departStation;
    private String arriveStation;
    private String seatType;
    private String departDate;
    private String bookDate;
    private String expiredDate;
    private String status;
    private int amount;
    private long totalPrice;
    private Location location;

    private enum Location {
        TABLE_ON_MY_TICKET,
        TABLE_ON_BOOK_TICKET,
        ALL_DROPDOWN_ON_TICKET
    }

    public TicketInfo(List<String> data) {
        if (data.size() == 11) {
            numOrder = Integer.parseInt(data.get(0));
            departStation = data.get(1);
            arriveStation = data.get(2);
            seatType = data.get(3);
            departDate = data.get(4);
            bookDate = data.get(5);
            expiredDate = data.get(6);
            status = data.get(7);
            amount = Integer.parseInt(data.get(8));
            totalPrice = Long.parseLong(data.get(9));
            location = Location.TABLE_ON_MY_TICKET;
        }

        if (data.size() == 8) {
            departStation = data.get(0);
            arriveStation = data.get(1);
            seatType = data.get(2);
            departDate = data.get(3);
            bookDate = data.get(4);
            expiredDate = data.get(5);
            amount = Integer.parseInt(data.get(6));
            totalPrice = Long.parseLong(data.get(7));
            location = Location.TABLE_ON_BOOK_TICKET;
        }
    }

    public TicketInfo(Map<String, String> data) {
        Arrays.stream(Dropdown.values()).forEach(x -> {
            String value = data.get(x.name());
            switch (x) {
                case DEPART_DATE:
                    departDate = value;
                    break;
                case DEPART_FROM:
                    departStation = value;
                    break;
                case ARRIVE_AT:
                    arriveStation = value;
                    break;
                case SEAT_TYPE:
                    seatType = value;
                    break;
                case TICKET_AMOUNT:
                    amount = Integer.parseInt(value);
                    break;
            }
        });
        location = Location.ALL_DROPDOWN_ON_TICKET;
    }

    private boolean equalsAllTicketInfo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketInfo that = (TicketInfo) o;
        return amount == that.amount &&
                totalPrice == that.totalPrice &&
                Objects.equals(departStation, that.departStation) &&
                Objects.equals(arriveStation, that.arriveStation) &&
                Objects.equals(seatType, that.seatType) &&
                Objects.equals(departDate, that.departDate) &&
                Objects.equals(bookDate, that.bookDate) &&
                Objects.equals(expiredDate, that.expiredDate) &&
                Objects.equals(status, that.status);
    }

    public boolean equalsBetweenTicketInfoWithDropdownInfo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketInfo that = (TicketInfo) o;
        return amount == that.amount &&
                Objects.equals(departStation, that.departStation) &&
                Objects.equals(arriveStation, that.arriveStation) &&
                Objects.equals(seatType, that.seatType) &&
                Objects.equals(departDate, that.departDate);
    }

    public boolean equalsBetweenTicketInfoWithBookingInfo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketInfo that = (TicketInfo) o;
        return amount == that.amount &&
                totalPrice == that.totalPrice &&
                Objects.equals(departStation, that.departStation) &&
                Objects.equals(arriveStation, that.arriveStation) &&
                Objects.equals(seatType, that.seatType) &&
                Objects.equals(departDate, that.departDate) &&
                Objects.equals(bookDate, that.bookDate) &&
                Objects.equals(expiredDate, that.expiredDate);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketInfo that = (TicketInfo) o;
        if (this.location == Location.ALL_DROPDOWN_ON_TICKET || that.location == Location.ALL_DROPDOWN_ON_TICKET)
            return this.equalsBetweenTicketInfoWithDropdownInfo(o);

        if (this.location == Location.TABLE_ON_BOOK_TICKET || that.location == Location.TABLE_ON_BOOK_TICKET)
            return this.equalsBetweenTicketInfoWithBookingInfo(o);

        return this.equalsAllTicketInfo(o);
    }
}
