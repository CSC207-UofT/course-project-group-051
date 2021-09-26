
public abstract class Bag {

    String color;
    int numberOfContents;
    int capacity;
    String[] contents;





    public Bag(String color, int capacity){
        this.setColor(color);
        this.capacity = capacity;
        this.numberOfContents = 0;
        this.contents = new String[capacity];


    }




    public String getColor(){

        return this.color;
    }
    public int getNumberOfContents(){
        return this.numberOfContents;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setColor(String color){
        this.color = color;
    }





    public boolean addItem(String item){
        if(this.numberOfContents >= this.capacity){
            return false;
        }
        else{
            this.contents[this.numberOfContents] = item;
            this.numberOfContents++;
            return true;
        }
    }





    /**
     * If there are no items in this Bag, return null.
     *
     * @return The string representation of the item last added to the bag.
     */
    public String popItem(){
        if (this.numberOfContents == 0){
            return null;
        }
        else{
            String[] temp = String[this.capacity]
                    for(int i = 0; i < this.numberOfContents - 1; i++){
                        temp[i] = this.contents[i]
                    }
                    String s = this.contents[this.numberOfContents - 1]
                    this.numberOfContents --;
                    this.contents = temp;
            return s;
        }}





    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        this.capacity += n;
        int i = 0;
        String[] temp= new String[this.capacity];
        while (i < this.numberOfContents){
            temp[i] = this.contents[i];
            i++;
        }
        this.contents = temp;

    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return the string representation of this bag
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }


    public abstract void enhance();
}