
package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.dto.BusDto;
import com.app.dto.FeedResDTO;
import com.app.dto.FeedbackDTO;
import com.app.dto.UserResponseDTO;
import com.app.entities.FeedBack;
import com.app.service.FeedBackService;


@RestController

@RequestMapping("/feedback")
@CrossOrigin(origins = "*")
public class FeedBackController {

    @Autowired
    private FeedBackService feedbackService;
    @GetMapping
	public List<FeedResDTO> listAllfeedback() {
		System.out.println("in list all passenger");
		return feedbackService.getAllFeedback();
	}

    @PostMapping
    public ResponseEntity<String> createFeedback(@RequestBody @Valid FeedbackDTO dto) {
    	System.out.println(FeedBack.class);
//        FeedbackDTO createFeedback=feedbackService.saveFeedback(dto);
//        return new ResponseEntity<>(cre;ateFeedback,HttpStatus.CREATED);
    	feedbackService.saveFeedback(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("feedbackcreated");
    }


@GetMapping("/{id}")
public ResponseEntity<?> getFeedbackDetails(@PathVariable Long id){
	System.out.println("in get Bus by id " + id);
	return ResponseEntity.ok(feedbackService.getFeedbackDetails(id));

}
@PutMapping("/{Id}")
public ResponseEntity<?> updateFeedback(@PathVariable Long Id,
		@RequestBody @Valid FeedbackDTO feedbackDTO) {
	System.out.println("in update feedback " +Id+" "+feedbackDTO );		
	return ResponseEntity.ok(feedbackService.updateFeedback(Id ,feedbackDTO));


}

			@DeleteMapping("/{id}")
			public ResponseEntity<?> deleteFeedback(@PathVariable Long id) {
				System.out.println("in delete feedback " +id);		
				return ResponseEntity.ok(feedbackService.deleteFeedback(id ));
			
				
}

}
