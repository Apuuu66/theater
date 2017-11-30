package com.ttms.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/16
 * Time: 16:16
 */
public class Schedule implements Serializable{
    private Integer sched_id;
    private Integer studio_id;
    private Integer play_id;
    private Date sched_time;
    private Double sched_ticket_rice;

    public Integer getSched_id() {
        return sched_id;
    }

    public void setSched_id(Integer sched_id) {
        this.sched_id = sched_id;
    }

    public Integer getStudio_id() {
        return studio_id;
    }

    public void setStudio_id(Integer studio_id) {
        this.studio_id = studio_id;
    }

    public Integer getPlay_id() {
        return play_id;
    }

    public void setPlay_id(Integer play_id) {
        this.play_id = play_id;
    }

    public Date getSched_time() {
        return sched_time;
    }

    public void setSched_time(Date sched_time) {
        this.sched_time = sched_time;
    }

    public Double getSched_ticket_rice() {
        return sched_ticket_rice;
    }

    public void setSched_ticket_rice(Double sched_ticket_rice) {
        this.sched_ticket_rice = sched_ticket_rice;
    }
}
