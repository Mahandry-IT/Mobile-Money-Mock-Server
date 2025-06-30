package papi.mobilemoney.mock.controller.mobilemoney.mvola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import papi.mobilemoney.mock.data.dto.mobilemoney.mvola.MvolaTokenRequest;
import papi.mobilemoney.mock.data.response.mobilemoney.mvola.MvolaTokenResponse;
import papi.mobilemoney.mock.services.mvola.token.MvolaTokenService;

import java.util.Map;

@RestController
@RequestMapping("/mvola")
public class MvolaController {

    @Autowired
    private MvolaTokenService service;

    @PostMapping("/token")
    public ResponseEntity<MvolaTokenResponse> pay(@RequestBody MvolaTokenRequest request, @RequestHeader Map<String, String> headers) {
        MvolaTokenResponse response = service.createMvolaToken(request, headers);
        return ResponseEntity.ok(response);
    }

}
