package leon.company.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import leon.company.webapp.classes.Interests;
import leon.company.webapp.classes.Profile;
import leon.company.webapp.services.ProfileService;

@RestController
public class WebController
{
    ProfileService webService;

    @Autowired
    WebController(ProfileService webService)
    {
        this.webService = webService;
    }

    @GetMapping("/")
    public String defaultString()
    {
        return webService.hello();
    }

    @GetMapping("/showProfiles")
    public Iterable<Profile> showProfiles()
    {
        return webService.getProfiles();
    }

    @GetMapping("/showInterests")
    public Iterable<Interests> showInterests()
    {
        return webService.getInterests();
    }

    @GetMapping("/showMyProfile/{Id}")
    public Profile getProfile(@PathVariable("Id") Long Id)
    {
        return webService.getProfile(Id);
    }

    @GetMapping("/showMeAReccomendation/{Id}")
    public Profile showReccomend(@PathVariable("Id") Long Id)
    {
        return webService.getAReccomendationFor(Id);
    }

    @GetMapping("/getMyInterests/{Id}")
    public Interests showInterests(@PathVariable("Id") Long Id)
    {
        return webService.getInterest(Id);
    }

    @PostMapping("/newInterest/{Id}")
    public void postInterests(@PathVariable("Id") Long Id, @RequestBody Interests interests)
    {
        webService.addInterest(Id, interests);
    }

    @PostMapping("/newProfile")
    public void postProfile(@RequestBody Profile profile)
    {
        webService.addProfile(profile);
    }

    @PutMapping("/putProfile/{username}/{Id}")
    public void putProfileUsername(@PathVariable("username") String username, @PathVariable("Id") Long Id)
    {
        webService.updateProfileUsername(Id, username);
    }

    @DeleteMapping("/deleteProfile/{Id}")
    public void deleteProfile(@PathVariable("Id") Long Id)
    {
        webService.removeProfile(Id);
    }
}