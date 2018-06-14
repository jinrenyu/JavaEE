package com.exam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="exam_record")
public class Record {
    /*
     * 记录主键
     */
    private Integer id;
    /*
     * 入住时间
     */
    private Date startDate;
    /*
     * 退房时间
     */
    private Date endDate;
    /*
     * 花费总价
     */
    private Double total;
    /*
     * 房间
     */
    private Room room;

    public Record() {
        super();
    }

    public Record(Integer id, Date startDate, Date endDate, Double total, Room room) {
        super();
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.total = total;
        this.room = room;
    }

    @Id
    @GeneratedValue(generator="gen_record_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_record_id", sequenceName="seq_record_id", allocationSize=1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Column
    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @ManyToOne
    @JoinColumn(name="roomId")
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    
}
