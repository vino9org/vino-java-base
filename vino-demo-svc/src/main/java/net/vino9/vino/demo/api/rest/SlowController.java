package net.vino9.vino.demo.api.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SlowController {
    final SlowService slow;

    public SlowController(SlowService slow) {
        this.slow = slow;
    }

    @GetMapping("/rest/slow")
    public String call() {
        return slow.randLong();
    }
}
// DELETE_IF: cookiecutter.cache_type != 'redis'
