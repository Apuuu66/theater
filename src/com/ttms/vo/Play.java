package com.ttms.vo;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Fionar
 * Date: 2017/11/16
 * Time: 15:41
 */
public class Play implements Serializable {
    private Integer play_id;
    private Integer play_type_id;
    private Integer play_lang_id;

    private String play_name;
    private String play_introduction;
    private String play_image;
    private String play_length;

    private Double play_ticket_price;
    private Integer play_status;

    public Integer getPlay_id() {
        return play_id;
    }

    public void setPlay_id(Integer play_id) {
        this.play_id = play_id;
    }

    public Integer getPlay_type_id() {
        return play_type_id;
    }

    public void setPlay_type_id(Integer play_type_id) {
        this.play_type_id = play_type_id;
    }

    public Integer getPlay_lang_id() {
        return play_lang_id;
    }

    public void setPlay_lang_id(Integer play_lang_id) {
        this.play_lang_id = play_lang_id;
    }

    public String getPlay_name() {
        return play_name;
    }

    public void setPlay_name(String play_name) {
        this.play_name = play_name;
    }

    public String getPlay_introduction() {
        return play_introduction;
    }

    public void setPlay_introduction(String play_introduction) {
        this.play_introduction = play_introduction;
    }

    public String getPlay_image() {
        return play_image;
    }

    public void setPlay_image(String play_image) {
        this.play_image = play_image;
    }

    public String getPlay_length() {
        return play_length;
    }

    public void setPlay_length(String play_length) {
        this.play_length = play_length;
    }


    public Integer getPlay_status() {
        return play_status;
    }

    public void setPlay_status(Integer play_status) {
        this.play_status = play_status;
    }

    public Double getPlay_ticket_price() {
        return play_ticket_price;
    }

    public void setPlay_ticket_price(Double play_ticket_price) {
        this.play_ticket_price = play_ticket_price;
    }
}
