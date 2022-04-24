package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Geometries implements Intersectable, Iterable<Geometry> {

        protected ArrayList<Geometry> geometriesList; // List of geometries


        /********* Constructors ***********/

        // defult
        public Geometries()
        {
            geometriesList = new ArrayList<>();
        }

        // add geometries to geometriesList
        public Geometries(Intersectable... geometries){
            geometriesList = new ArrayList<>();

            for (Intersectable geometry : geometries){
                geometriesList.add((Geometry) geometry);
            }
        }

        //add ArrayList of geometries to geometriesList
        public Geometries(ArrayList<Geometry> geometries){
            geometriesList = new ArrayList<>();

            geometriesList.addAll(geometries);
        }

        /********* Getters ***********/

        public ArrayList<Geometry> get_GeometriesList() {
            ArrayList<Geometry> result = new ArrayList<>();

            result.addAll(geometriesList);

            return result;
        }


        /************* Methods ***************/

        public void add_geometries(Intersectable... geometries) {
            for (Intersectable geometry: geometries) {
                geometriesList.add((Geometry) geometry);
            }
        }


        @Override
        public List<Point> findIntersections(Ray ray) {
            ArrayList<Point> result = new ArrayList<>();;
            // for each loop over geometriesList
            for (Geometry geometry : geometriesList){

                result.addAll(geometry.findIntersections(ray)); // operate the right  findIntersections per geometry
            }

            return result;
        }

    @Override
    public Iterator<Geometry> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super Geometry> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Geometry> spliterator() {
        return Iterable.super.spliterator();
    }
}
