package com.exam.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.exam.convert.StatusConvert;
import com.exam.entity.enumeration.Status;

@Entity
@Table(name="exam_room")
public class Room {
    /*
     * 记录主键
     */
    private Integer id;
    /*
     * 房间编号
     */
    private String code;
    /*
     * 房间类型
     */
    private String roomType;
    /*
     * 每小时的价格
     */
    private Double hourPrice;
    /*
     * 房间状态:未入住, 已入住, 已退房
     */
    private Status status;
    /*
     * 居住记录
     */
    private List<Record> records;

    public Room() {
        super();
    }
    
    public Room(Integer id, String code, String roomType, Double hourPrice, Status status, List<Record> records) {
        super();
        this.id = id;
        this.code = code;
        this.roomType = roomType;
        this.hourPrice = hourPrice;
        this.status = status;
        this.records = records;
    }

    @Id
    @GeneratedValue(generator="gen_room_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_room_id", sequenceName="seq_room_id", allocationSize=1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name="rType")
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Column(name="price")
    public Double getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(Double hourPrice) {
        this.hourPrice = hourPrice;
    }

    @Column
    @Convert(converter=StatusConvert.class)
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToMany(mappedBy="room")
    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
    
}
