/**
 * Created by T440P on 2017/3/4.
 */
package com.wangmeng.maven;

public class SampleForSurefire {
    private float real;
    private float image;

    SampleForSurefire(float a, float b){
        this.real = a;
        this.image = b;
    }

    void SampleAdd(SampleForSurefire other){
        this.real += other.real;
        this.image += other.image;
    }

    float getReal()  {return this.real;}
    float getImage() {return this.image;}

    void show(){
        System.out.print(this.real);
        System.out.print("+");
        System.out.print(this.image);
        System.out.print("i");
    }

}
