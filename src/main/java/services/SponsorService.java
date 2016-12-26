package services;

import models.Sponsor;

import java.util.List;

/**
 * Created by LulzimG on 19/12/16.
 */
public interface SponsorService {
    List<Sponsor> getSponsorsForProject(String projectId);

    String insertSponsor(Sponsor sponsor);

    String removeSponsor(String id);
}
