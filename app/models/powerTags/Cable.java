package models.powerTags;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import models.Poi;
import models.PowerTag;
import models.powerTags.types.Operator;

@Entity
public class Cable extends PowerTag {

	public enum LocationEnum {
		NULL(" ", null), OVERGROUND("Overground", "overground"), UNDERGROUND("Underground", "underground"), UNDERWATER(
				"Underwater", "underwater");

		public final String name;
		public final String osm;

		LocationEnum(String name, String osm) {
			this.name = name;
			this.osm = osm;
		}
	}

	public String cables;
	public Byte circuits;
	public Float frequency;
	public LocationEnum location;
	public String name;

	@OneToOne(mappedBy = "powerTag", cascade = CascadeType.ALL)
	public Operator operator;

	public String ref;
	public Float voltage;

	public Cable(Poi poi) {
		super(poi);
	}
}