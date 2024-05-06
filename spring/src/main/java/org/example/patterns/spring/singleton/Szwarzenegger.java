package org.example.patterns.spring.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class Szwarzenegger {

    @Autowired
    @Lazy //if Lazy in this place - will work even if any class have injected this bean. Since v4.3
    // Will Proxy be injected initialy- and if methods from original will be needed
    private Blaster blaster;
    private int stamina = 3;

    //Example of constructor lazy injecting
//    @Autowired
//    public Szwarzenegger(@Lazy Blaster blaster) {
//        this.blaster = blaster;
//    }

    //Example Lazy with Lombok:
    //RequiredArgsConstructor(onConstructor_ = { @Lazy } )

//    @Scheduled(fixedDelay = 500)
    public void killEnemies(){
        if(!veryTired()){
            kickWithLog();
        }else {
            blaster.fire();
        }
        stamina--;
    }

    private void kickWithLog() {
        System.out.println("I'll kill you with my log!");
    }

    private boolean veryTired() {
        return stamina < 1;
    }

}
