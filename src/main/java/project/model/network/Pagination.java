package project.model.network;

public class Pagination{
    private Integer totalPages;
    private Long totalElements;
    private Integer currentPage;
    private Integer currentElements;
    
    public Pagination(){}
    
    public Integer getTotalPages(){return totalPages;}
    public Long getTotalElements(){return totalElements;}
    public Integer getCurrentPage(){return currentPage;}
    public Integer getCurrentElements(){return currentElements;}
    
    public void setTotalPages(Integer totalPages){this.totalPages=totalPages;}
    public void setTotalElements(Long totalElements){this.totalElements=totalElements;}
    public void setCurrentPage(Integer currentPage){this.currentPage=currentPage;}
    public void setCurrentElements(Integer currentElements){this.currentElements=currentElements;}
}