/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.*;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    public boolean addDrivable(String ID, Drivable d){
        if (this.drivable_map.containsKey(ID)){
            return false;
        }
        else{
            this.drivable_map.put(ID, d);
            return true;
        }
    }



    /*
     * You may want to use drivable_map.keys() or drivable_map.values() to
     * iterate through drivable_map.
     */
    public boolean hasFasterThan(int speed){
        boolean res = false;
        for (Drivable i: this.drivable_map.values()){
            if (i.getMaxSpeed() >= speed) {
                res = true;
            }
        }
        return res;
    }



    public List getTradable(){
        List i = new ArrayList();

        for(Drivable d:this.drivable_map.values()){
            if(d instanceof Tradable){
                i.add(d);
            }

        }
        return i;
            }}

