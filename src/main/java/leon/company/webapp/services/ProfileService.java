package leon.company.webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import leon.company.webapp.classes.Interests;
import leon.company.webapp.classes.Profile;
import leon.company.webapp.exceptions.ResourceNotFoundException;
import leon.company.webapp.repository.InterestsRepository;
import leon.company.webapp.repository.ProfileRepository;

@Service
public class ProfileService
{

    ProfileRepository profileRepository;
    InterestsRepository interestsRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository, InterestsRepository interestsRepository)
    {
        this.profileRepository = profileRepository;
        this.interestsRepository = interestsRepository;
    }
    
    public String hello()
    {
        return "Hello bossi";
    }

    public Iterable<Profile> getProfiles()
    {
        return profileRepository.findAll();
    }

    public Iterable<Interests> getInterests()
    {
        return interestsRepository.findAll();
    }

    public Profile getAReccomendationFor(Long Id)
    {
        Interests mainP = getInterest(Id);

        for(Long i = Id - 5; i < Id; i++)
        {
            Interests recP = getInterest(i);
            System.out.print(mainP.getInterest1());
            System.out.println(recP.getInterest1());
            if(mainP.getInterest1().equals(recP.getInterest1()))
            {
                return getProfile(i);
            }
        }
        return null;
    }

    public Profile getProfile(Long Id)
    {
        return profileRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Id: " + Id));
    }

    public Interests getInterest(Long Id)
    {
        return interestsRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Id: " + Id));
    }

    public void addProfile(Profile profile)
    {
        profileRepository.save(profile);
    }

    public void addInterest(Long Id, Interests interests)
    {
        Profile updateProfile = getProfile(Id);

        interests.setId(updateProfile.getId());
        updateProfile.setInterests(interests);

        profileRepository.save(updateProfile);
    }

    public void updateProfileUsername(Long Id, String username)
    {
        Profile updateProfile = profileRepository.findById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with Id: " + Id));

        updateProfile.setUsername(username);
        
        profileRepository.save(updateProfile);
    }

    public void removeProfile(Long Id)
    {
        profileRepository.deleteById(Id);
    }
}