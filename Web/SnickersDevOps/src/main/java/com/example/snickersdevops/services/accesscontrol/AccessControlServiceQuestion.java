package com.example.snickersdevops.services.accesscontrol;

import com.example.snickersdevops.models.Question;
import org.springframework.stereotype.Service;

@Service
public class AccessControlServiceQuestion extends AccessControlServiceUserOwned<Question> {

}
