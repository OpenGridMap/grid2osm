package models.powerTags;

import javax.persistence.Entity;

import models.Poi;
import models.PowerTag;

@Entity
public class Converter extends PowerTag {

	public enum ConverterEnum {
		BACK_TO_BACK("Back-To-Back"), LCC("LCC"), VSC("VSC");

		public final String name;

		ConverterEnum(String name) {
			this.name = name;
		}
	}

	public ConverterEnum converter;
	public Byte poles;
	public Long rating;
	public Float voltage;

	public Converter(Poi poi) {
		super(poi);
	}
}