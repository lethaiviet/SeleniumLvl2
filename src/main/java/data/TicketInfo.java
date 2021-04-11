package data;

import io.cucumber.java.eo.Se;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    public TicketInfo(List<String> d) {
        if (d.size() == 11) {
            numOrder = Integer.parseInt(d.get(0));
            departStation = d.get(1);
            arriveStation = d.get(2);
            seatType = d.get(3);
            departDate = d.get(4);
            bookDate = d.get(5);
            expiredDate = d.get(6);
            status = d.get(7);
            amount = Integer.parseInt(d.get(8));
            totalPrice = Long.parseLong(d.get(9));
        }

        if (d.size() == 8) {
            departStation = d.get(0);
            arriveStation = d.get(1);
            seatType = d.get(2);
            departDate = d.get(3);
            bookDate = d.get(4);
            expiredDate = d.get(5);
            amount = Integer.parseInt(d.get(6));
            totalPrice = Long.parseLong(d.get(7));
        }
    }
}
