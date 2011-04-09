package pojo;
// Generated Mar 29, 2011 10:22:08 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Event generated by hbm2java
 */
@Entity
@Table(name="event"
    ,catalog="entitydb"
)
public class Event  implements java.io.Serializable {


     private String entityId;
     private Entitybase entitybase;
     private Date eventStartDate;
     private Date eventEndDate;

    public Event() {
    }

	
    public Event(String entityId, Entitybase entitybase, Date eventStartDate) {
        this.entityId = entityId;
        this.entitybase = entitybase;
        this.eventStartDate = eventStartDate;
    }
    public Event(String entityId, Entitybase entitybase, Date eventStartDate, Date eventEndDate) {
       this.entityId = entityId;
       this.entitybase = entitybase;
       this.eventStartDate = eventStartDate;
       this.eventEndDate = eventEndDate;
    }
   
     @Id 
    
    @Column(name="EntityID", unique=true, nullable=false, length=40)
    public String getEntityId() {
        return this.entityId;
    }
    
    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EntityID", unique=true, nullable=false, insertable=false, updatable=false)
    public Entitybase getEntitybase() {
        return this.entitybase;
    }
    
    public void setEntitybase(Entitybase entitybase) {
        this.entitybase = entitybase;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EventStartDate", nullable=false, length=19)
    public Date getEventStartDate() {
        return this.eventStartDate;
    }
    
    public void setEventStartDate(Date eventStartDate) {
        this.eventStartDate = eventStartDate;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EventEndDate", length=19)
    public Date getEventEndDate() {
        return this.eventEndDate;
    }
    
    public void setEventEndDate(Date eventEndDate) {
        this.eventEndDate = eventEndDate;
    }




}


