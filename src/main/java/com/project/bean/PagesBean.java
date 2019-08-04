package com.project.bean;

public class PagesBean {
	  private Integer pageNow=1;      //当前页数

      private Integer pageSize=8;     //每页显示的数量

      private Integer totalCount;     //总记录数

      private Integer totalPageCount;      //总页数

      private Integer startPos;        //开始位置，从0开始
      
      private String status;
      
      private  Integer ad_id;
      
      private String name;


      public PagesBean(Integer pageNow, Integer totalCount) {
        
          this.pageNow = pageNow;
          this.totalCount = totalCount;
          
      }
      //获取总页数
      public int getTotalPageCount() {
          totalPageCount=getTotalCount()/getPageSize();
          return (totalCount%pageSize==0) ? totalPageCount:totalPageCount+1;
      }

      public void setTotalPageCount(Integer totalPageCount) {
          this.totalPageCount = totalPageCount;
      }

      public int getPageNow() {
          return pageNow;
      }

      public void setPageNow(Integer pageNow) {
          this.pageNow = pageNow;
      }

      public int getPageSize() {
          return pageSize;
      }

      public void setPageSize(Integer pageSize) {
          this.pageSize = pageSize;
      }

      public int getTotalCount() {
          return totalCount;
      }

      public void setTotalCount(int totalCount) {
          this.totalCount = totalCount;
      }
      //取得选择记录的初始位置
      public int getStartPos() {
          return (pageNow-1)*pageSize;
      }

      public void setStartPos(int startPos) {
          this.startPos = startPos;
      }
     
     

	public PagesBean(){
		
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAd_id() {
		return ad_id;
	}
	public void setAd_id(Integer ad_id) {
		this.ad_id = ad_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
