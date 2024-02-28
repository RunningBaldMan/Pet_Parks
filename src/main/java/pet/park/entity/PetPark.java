package pet.park.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PetPark {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petParkId;
	private String parkName;
	private String directions;
	private String stateOrProvince;
	private String country;
	private GeoLocation geoLocation;
	private PetParkContributor contributor;
	private Set<String> amenities = new HashSet<>();
	
	public void PetParkData(PetPark petPark) {
		petParkId = petPark.getPetParkId();
		parkName = petPark.getParkName();
		directions = petPark.getDirections();
		stateOrProvince = petPark.getStateOrProvince();
		country = petPark.getCountry();
		geoLocation = petPark.getGeoLocation();
		contributor = new PetParkContributor(petPark.getContributor());
		
		for(String amenity : petPark.getAmenities()) {
			amenities.add(amenity.getAmenity());
		}
	}
	
	@Data
	@NoArgsConstructor
	public static class PetParkContributor {
		private Long contributorID;
		private String contributorName;
		private String contributorEmail;
		
		public PetParkContributor(Contributor contributor) {
			contributorID = contributor.getContributorID();
			contributorName = contributor.getContributorName();
			contributorEmail = contributor.getContributorEmail();
		}
	}
}

