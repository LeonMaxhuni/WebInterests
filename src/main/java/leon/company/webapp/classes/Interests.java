package leon.company.webapp.classes;

// import jakarta.persistence.Column;
// import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
// import jakarta.persistence.MapsId;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.PrimaryKeyJoinColumn;
// import leon.company.webapp.enums.InterestConverter;
// import leon.company.webapp.enums.InterestEnums;

@Entity
public class Interests
{
    @Id
    private Long Id;

    private String interest1;

    public String getInterest1()
    {
        return interest1;
    }

    public void setInterest1(String interest1)
    {
        this.interest1 = interest1;
    }

    public Long getId()
    {
        return Id;
    }

    public void setId(Long id)
    {
        Id = id;
    }

    // public Profile getProfile()
    // {
    //     return profile;
    // }

    // public void setProfile(Profile profile)
    // {
    //     this.profile = profile;
    // }
}