package com.ThymleafProject_Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/students")
	public String studentInfo(Model model) {
		List<Student> students = studentRepository.findAll();
		model.addAttribute("students", students);
		model.addAttribute("newStudent", new Student());
		return "students";
	}

	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("newStudent") Student student) {
		studentRepository.save(student); // Save to the database
		return "redirect:/students"; // Redirect back to student page
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
}
