import com.Nuntius.Nuntius.model.Encryption;
import com.Nuntius.Nuntius.repository.EncryptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/encryption")
public class EncryptionController {

    @Autowired
    private EncryptionRepository encryptionRepository;

    @GetMapping
    public List<Encryption> getAllEncryptions() {
        return encryptionRepository.findAll();
    }

    @PostMapping
    public Encryption createEncryption(@RequestBody Encryption encryption) {
        return encryptionRepository.save(encryption);
    }
}
