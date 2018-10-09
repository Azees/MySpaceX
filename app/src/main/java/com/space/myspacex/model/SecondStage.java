
package com.space.myspacex.model;

import java.util.List;

public class SecondStage {

    private Integer block;
    private List<Payload> payloads = null;

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

}
