package com.infytel.repository;

import com.infytel.dto.CallDetailsDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CallDetailsRepository {
    List<CallDetailsDTO> callDetails = null;
    CallDetailsDTO callDetailsDTO = null;
    CallDetailsDTO callDetailsDTO1 = null;
    LocalDate calledOn = LocalDate.now();
    // Populating CallDetailsDTO
    @PostConstruct
    public void populatecalledOn() {
        callDetails = new ArrayList<>();
        callDetailsDTO = new CallDetailsDTO();
        callDetailsDTO1 = new CallDetailsDTO();
        calledOn = LocalDate.now();
        callDetailsDTO.setCalledBy(8870106465l);
        callDetailsDTO.setCalledTo(9930508495l);
        callDetailsDTO.setCalledOn(calledOn);
        callDetailsDTO.setDuration(3);
        callDetailsDTO1.setCalledBy(8870106465l);
        callDetailsDTO1.setCalledTo(9930508495l);
        callDetailsDTO1.setCalledOn(calledOn);
        callDetailsDTO1.setDuration(5);
        callDetails.add(callDetailsDTO);
        callDetails.add(callDetailsDTO1);
    }
    // To fetch call details based on calledBy and calledOn attributes of
    // CallDetailsDTO
    public List<CallDetailsDTO> fetchCallDetails(long calledBy, LocalDate calledOn) {
        List<CallDetailsDTO> callDetailsResultSet = new ArrayList<>();
        for (CallDetailsDTO callDetail : callDetails) {
            if (callDetail.getCalledBy() == calledBy && callDetail.getCalledOn().equals(calledOn))
                callDetailsResultSet.add(callDetail);
        }
        return callDetailsResultSet;
    }
}
