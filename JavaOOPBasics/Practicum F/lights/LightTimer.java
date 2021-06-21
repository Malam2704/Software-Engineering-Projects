package lights;

public class LightTimer implements Runnable {
    Light l;

    public LightTimer(Light light){
        this.l = light;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        if(l.getOnOff() != 0){
            l.switchLight();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //TODO: handle exception
            }
            l.switchLight();
        }else{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                //TODO: handle exception
            }
        }
    }

    public static void main(String[] args) {
        LightTimer lt = new LightTimer(new BasicLight());
    }
    
}

