/*
 * Entidad Game en donde se modela la tabla
 */
package Model;
	import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
	import java.io.Serializable;
	import java.util.List;
	import javax.persistence.CascadeType;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.JoinColumn;
	import javax.persistence.ManyToOne;
	import javax.persistence.OneToMany;
	import javax.persistence.Table;
	
	@Entity
	@Table(name = "game")
	public class Game implements Serializable{
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	    private String developer;
	    private Integer minage;
	    private String name;
            private String description;
	    
	    @ManyToOne
	    @JoinColumn(name = "categoryId")
	    @JsonIgnoreProperties("games")
	    private Categoria category;
	
	    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "game")
	    @JsonIgnoreProperties({"game", "client"})
	    private List<Mensaje> messages;
            
            @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "game")
	    @JsonIgnoreProperties({"game", "client"})
	    private List<Reservaciones> reservacion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public Integer getMinage() {
        return minage;
    }

    public void setMinage(Integer minage) {
        this.minage = minage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Categoria getCategory() {
        return category;
    }

    public void setCategory(Categoria category) {
        this.category = category;
    }

    public List<Mensaje> getMessages() {
        return messages;
    }

    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    public List<Reservaciones> getReservacion() {
        return reservacion;
    }

    public void setReservacion(List<Reservaciones> reservacion) {
        this.reservacion = reservacion;
    }

  
    }

    
