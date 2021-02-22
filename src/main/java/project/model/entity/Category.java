package project.model.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Category{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String type;
    
    private String title;
    
    @CreatedDate
    private LocalDateTime createdAt;
    
    @CreatedBy
    private String createdBy;
    
    @LastModifiedDate
    private LocalDateTime updatedAt;
    
    @LastModifiedBy
    private String updatedBy;
    
    // Category 1 : N Partner
    @OneToMany(fetch=FetchType.LAZY, mappedBy="category")
    private List<Partner> partnerList;
    
    public Category() {}
    public Category(Long id, String type, String title, LocalDateTime createdAt, String createdBy, LocalDateTime updatedAt, String updatedBy, List<Partner> partnerList){
        this.id=id;
        this.type=type;
        this.title=title;
        this.createdAt=createdAt;
        this.createdBy=createdBy;
        this.updatedAt=updatedAt;
        this.updatedBy=updatedBy;
        this.partnerList=partnerList;
    }
    public Long getId() { return id; }
    public String getType(){return type;}
    public String getTitle(){return title;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getCreatedBy(){return createdBy;}
    public LocalDateTime getUpdatedAt(){return updatedAt;}
    public String getUpdatedBy(){return updatedBy;}
    public List<Partner> getPartnerList(){return partnerList;}
    
    public void setId(Long id) { this.id=id;}
    public void setType(String type){this.type=type;}
    public void setTitle(String title){this.title=title;}
    public void setCreatedAt(LocalDateTime createdAt){this.createdAt=createdAt;}
    public void setCreatedBy(String createdBy){this.createdBy=createdBy;}
    public void setUpdatedAt(LocalDateTime updatedAt){this.updatedAt=updatedAt;}
    public void setUpdatedBy(String updatedBy){this.updatedBy=updatedBy;}
    public void setPartnerList(List<Partner> partnerList){this.partnerList=partnerList;}
}