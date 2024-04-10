package shshon.study

import org.geotools.data.DataStoreFinder
import org.geotools.data.FeatureSource
import org.geotools.feature.FeatureCollection
import org.opengis.feature.simple.SimpleFeature
import org.opengis.feature.simple.SimpleFeatureType
import org.opengis.filter.Filter
import java.io.File


class GeotoolsHelper {

    fun read() {
        val file = File("/Users/shonsanghun/dev/projects/shshon-study/kotlin-study/app/src/main/resources/file/BND_SIGUNGU_PG.shp")
        val map: MutableMap<String, Any?> = HashMap()
        map["url"] = file.toURI().toURL()

        val dataStore = DataStoreFinder.getDataStore(map)
        val typeName = dataStore.typeNames[0]

        val source: FeatureSource<SimpleFeatureType, SimpleFeature> = dataStore.getFeatureSource(typeName)
        val filter: Filter = Filter.INCLUDE // ECQL.toFilter("BBOX(THE_GEOM, 10,20,30,40)")


        val collection: FeatureCollection<SimpleFeatureType, SimpleFeature> = source.getFeatures(filter)
        collection.features().use { features ->
            while (features.hasNext()) {
                val feature = features.next()
                print(feature.id)
                print(": ")
                println(feature.defaultGeometryProperty.value)
            }
        }
    }
}
