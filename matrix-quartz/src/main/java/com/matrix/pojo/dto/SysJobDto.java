package com.matrix.pojo.dto;

import java.util.List;

public class SysJobDto {
    private Integer flagEnable;
    private List<String> rglist; //  runGroupDid list - Yangcl 
    
	public Integer getFlagEnable() {
		return flagEnable;
	}
	public void setFlagEnable(Integer flagEnable) {
		this.flagEnable = flagEnable;
	}
	public List<String> getRglist() {
		return rglist;
	}
	public void setRglist(List<String> rglist) {
		this.rglist = rglist;
	}
    
    
}
