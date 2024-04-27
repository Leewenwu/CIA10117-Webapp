package com.reserve;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reserve_order")
public class ReserveOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserve_orderid", nullable = false)
    private Integer reserveOrderId;

    @Column(name = "reserve_session_id", nullable = false)
    private Integer reserveSessionId;

    @Column(name = "member_id", nullable = false)
    private Integer memberId;

    @Column(name = "reserve_order_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date reserveOrderDate;

    @Column(name = "reserve_number", nullable = false)
    private Integer reserveNumber;

    @Column(name = "reserve_order_state", nullable = false)
    private Integer reserveOrderState = 1;

    @Column(name = "booking_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookingDate;

    @Column(name = "order_note", length = 50)
    private String orderNote;
    
    @ManyToOne
    @JoinColumn(name = "reserve_session_id", referencedColumnName = "reserve_session_id")
    private ReserveSession reserveSession;

	public Integer getReserveOrderId() {
		return reserveOrderId;
	}

	public void setReserveOrderId(Integer reserveOrderId) {
		this.reserveOrderId = reserveOrderId;
	}

	public Integer getReserveSessionId() {
		return reserveSessionId;
	}

	public void setReserveSessionId(Integer reserveSessionId) {
		this.reserveSessionId = reserveSessionId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Date getReserveOrderDate() {
		return reserveOrderDate;
	}

	public void setReserveOrderDate(Date reserveOrderDate) {
		this.reserveOrderDate = reserveOrderDate;
	}

	public Integer getReserveNumber() {
		return reserveNumber;
	}

	public void setReserveNumber(Integer reserveNumber) {
		this.reserveNumber = reserveNumber;
	}

	public Integer getReserveOrderState() {
		return reserveOrderState;
	}

	public void setReserveOrderState(Integer reserveOrderState) {
		this.reserveOrderState = reserveOrderState;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getOrderNote() {
		return orderNote;
	}

	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}

	public ReserveSession getReserveSession() {
		return reserveSession;
	}

	public void setReserveSession(ReserveSession reserveSession) {
		this.reserveSession = reserveSession;
	}

	public ReserveOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ReserveOrder [reserveOrderId=" + reserveOrderId + ", reserveSessionId=" + reserveSessionId
				+ ", memberId=" + memberId + ", reserveOrderDate=" + reserveOrderDate + ", reserveNumber="
				+ reserveNumber + ", reserveOrderState=" + reserveOrderState + ", bookingDate=" + bookingDate
				+ ", orderNote=" + orderNote + ", reserveSession=" + reserveSession + "]";
	}

    
}
