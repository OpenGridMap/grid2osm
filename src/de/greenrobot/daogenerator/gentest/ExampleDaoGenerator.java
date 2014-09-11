/*
 * Copyright (C) 2011 Markus Junginger, greenrobot (http://greenrobot.de)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.greenrobot.daogenerator.gentest;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * Generates entities and DAOs for the example project DaoExample.
 * 
 * Run it as a Java application (not Android).
 * 
 * @author Markus
 */
public class ExampleDaoGenerator {

	public static void main(String[] args) throws Exception {
		Schema schema = new Schema(3, "org.grid2osm.gisapp");

		addPoi(schema);

		new DaoGenerator().generateAll(schema, "../GisApp/src-gen");
	}

	public static void addPoi(Schema schema) {
		Entity poiEntities = schema.addEntity("PoiEntities");
		poiEntities.addIdProperty().autoincrement();

		Entity poiEntity = schema.addEntity("PoiEntity");
		poiEntity.addIdProperty().autoincrement();
		poiEntity.addBooleanProperty("done");

		Entity locationEntities = schema.addEntity("LocationEntities");
		locationEntities.addIdProperty().autoincrement();

		Entity locationEntity = schema.addEntity("LocationEntity");
		locationEntity.addIdProperty().autoincrement();
		locationEntity.addFloatProperty("accuracy");
		locationEntity.addDoubleProperty("altitude");
		locationEntity.addFloatProperty("bearing");
		locationEntity.addDoubleProperty("latitude");
		locationEntity.addDoubleProperty("longitude");
		locationEntity.addStringProperty("provider");
		locationEntity.addLongProperty("time");

		Entity photoEntities = schema.addEntity("PhotoEntities");
		photoEntities.addIdProperty().autoincrement();

		Entity photoEntity = schema.addEntity("PhotoEntity");
		photoEntity.addIdProperty().autoincrement();
		photoEntity.addFloatProperty("accuracy");
		photoEntity.addDoubleProperty("altitude");
		photoEntity.addFloatProperty("bearing");
		photoEntity.addDoubleProperty("latitude");
		photoEntity.addDoubleProperty("longitude");
		photoEntity.addStringProperty("provider");
		photoEntity.addLongProperty("time");
		photoEntity.addStringProperty("filePath");

		Entity primitiveAttributesEntity = schema
				.addEntity("PrimitiveAttributesEntity");
		primitiveAttributesEntity.addIdProperty().autoincrement();
		primitiveAttributesEntity.addBooleanProperty("accountPickerIsOpen");
		primitiveAttributesEntity.addLongProperty("accumulatedTransferSize");
		primitiveAttributesEntity.addBooleanProperty("gesturesEnabled");
		primitiveAttributesEntity.addStringProperty("gMail");
		primitiveAttributesEntity.addStringProperty("gToken");
		primitiveAttributesEntity.addIntProperty("imageViewIndex");
		primitiveAttributesEntity.addBooleanProperty("locationTraceEnabled");
		primitiveAttributesEntity.addStringProperty("photoFilePath");
		primitiveAttributesEntity.addIntProperty("progressBar");
		primitiveAttributesEntity.addIntProperty("progressCircle");
		primitiveAttributesEntity.addBooleanProperty("resumeSend");
		primitiveAttributesEntity.addBooleanProperty("takeAnotherPhoto");
		primitiveAttributesEntity.addLongProperty("totalTransferSize");

		Property poiEntitiesId = poiEntity.addLongProperty("poiEntitiesId")
				.notNull().getProperty();
		Property locationEntitiesIdProperty = poiEntity
				.addLongProperty("locationEntitiesId").notNull().getProperty();
		Property photoEntitiesIdProperty = poiEntity
				.addLongProperty("photoEntitiesId").notNull().getProperty();
		Property locationEntitiesId = locationEntity
				.addLongProperty("locationEntitiesId").notNull().getProperty();
		Property photoEntitiesId = photoEntity
				.addLongProperty("photoEntitiesId").notNull().getProperty();

		poiEntities.addToMany(poiEntity, poiEntitiesId);
		poiEntity.addToOne(locationEntities, locationEntitiesIdProperty);
		poiEntity.addToOne(photoEntities, photoEntitiesIdProperty);
		locationEntities.addToMany(locationEntity, locationEntitiesId);
		photoEntities.addToMany(photoEntity, photoEntitiesId);
	}
}
