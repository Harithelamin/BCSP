package com.bcsp.project.controller;

import com.bcsp.project.model.*;
import com.bcsp.project.service.DimensionsDocumentService;
import com.bcsp.project.service.DimensionsService;
import com.bcsp.project.service.UserProfileService;
import com.bcsp.project.service.UserService;
import com.bcsp.project.util.FileValidator;
import com.bcsp.project.util.ImageValidator;
import com.bcsp.project.util.ToolsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.multipart.support.StringMultipartFileEditor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.*;


@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController {

    @Autowired
    UserService userService;

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    DimensionsService dimensionsService;

    @Autowired
    DimensionsDocumentService dimensionsDocumentService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    //
    @Autowired
    FileValidator fileValidator;

    @Autowired
    ToolsValidator toolsValidator;

    //
    @Autowired
    ImageValidator imageValidator;

    //
    @InitBinder("fileBucket")
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(fileValidator);
    }

    //
    @InitBinder
    public void myInitBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(byte[].class, new StringMultipartFileEditor());
        Object target = dataBinder.getTarget();
        if (target == null) {
            return;
        }
        System.out.println("Target=" + target);

        if (target.getClass() == Dimensions.class) {
            // For upload Image.
            dataBinder.registerCustomEditor(byte[].class, new StringMultipartFileEditor());
        }
    }

    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
            throws ServletException {

        // Convert multipart object to byte[]
        binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());

    }

    //list
    private void populateDefaultModelp(ModelMap model) {


        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        model.addAttribute("numberList", numbers);

        List<Integer> years = new ArrayList<Integer>();
        years.add(2015);
        years.add(2016);
        years.add(2017);
        years.add(2018);
        //years.add(2019);
        model.addAttribute("yearsList", years);

        List<Integer> monthes = new ArrayList<Integer>();
        monthes.add(1);
        monthes.add(2);
        monthes.add(3);
        monthes.add(4);
        monthes.add(5);
        monthes.add(6);
        monthes.add(7);
        monthes.add(8);
        monthes.add(9);
        monthes.add(10);
        monthes.add(11);
        monthes.add(12);
        model.addAttribute("monthsList", monthes);

        Map<String, String> days = new LinkedHashMap<String, String>();
        days.put("1", "1");
        days.put("2", "2");
        days.put("3", "3");
        days.put("4", "4");
        days.put("5", "5");
        days.put("6", "6");
        days.put("7", "7");
        days.put("8", "8");
        days.put("9", "9");
        days.put("10", "10");
        days.put("11", "11");
        days.put("12", "12");
        days.put("13", "13");
        days.put("14", "14");
        days.put("15", "15");
        days.put("16", "16");
        days.put("17", "17");
        days.put("18", "18");
        days.put("19", "19");
        days.put("20", "20");
        days.put("21", "21");
        days.put("22", "22");
        days.put("23", "23");
        days.put("24", "24");
        days.put("25", "25");
        days.put("26", "26");
        days.put("27", "27");
        days.put("28", "28");
        days.put("29", "29");
        days.put("30", "30");
        days.put("31", "31");
        model.addAttribute("daysList", days);


        Map<String, String> vasculAraccess = new LinkedHashMap<String, String>();
        vasculAraccess.put("AVF", "AVF");
        vasculAraccess.put("AVG", "AVG");
        vasculAraccess.put("Permcath", "Permcath");
        vasculAraccess.put("Temporal catheter", "Temporal catheter");
        model.addAttribute("vascularAccessList", vasculAraccess);

        List<String> surgeonsList = new ArrayList<String>();
        surgeonsList.add("Kamal");
        surgeonsList.add("Kashif");
        surgeonsList.add("Nazar");
        surgeonsList.add("Tayeb");
        surgeonsList.add("Sarra");
        surgeonsList.add("Other");
        model.addAttribute("surgeonsList", surgeonsList);


        List<String> hdDaysList = new ArrayList<String>();
        hdDaysList.add("Saturday");
        hdDaysList.add("Sunday");
        hdDaysList.add("Monday");
        hdDaysList.add("Tuesday");
        hdDaysList.add("Wednesday");
        hdDaysList.add("Thursday");
        model.addAttribute("hdDaysList", hdDaysList);

        Map<String, String> residence = new LinkedHashMap<String, String>();
        residence.put("Norway", "Norway");
        residence.put("Sweeden", "Sweeden");
        residence.put("USA", "USA");
        model.addAttribute("residenceList", residence);

    }

    /**
     * Home
     */
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home(ModelMap model) {
        return "bcsp/index";
    }


    @RequestMapping("/index")
    public String redirectPage() {
        return "bcsp/index";
    }


    @RequestMapping("/Welcome")
    public String showHomePage() {
        return "bcsp/index";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        return "bcsp/about";
    }


    @RequestMapping("/contact")
    public String contactPage() {
        return "bcsp/contact";
    }

    @RequestMapping("/guide")
    public String adjustPage() {
        return "bcsp/guide";
    }


    //@RequestMapping("/Welcome")
    //public String showHomePage() {
    //	return "index";
    //}

    @RequestMapping(value = {"/userslist"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "bcsp/userslist";
    }

    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "bcsp/usersregistration";
    }


    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
                           ModelMap model) {

        if (result.hasErrors()) {
            return "bcsp/usersregistration";
        }

        if (!userService.isUserPERSONIDUnique(user.getId(), user.getPersonId())) {
            FieldError personIdError = new FieldError("user", "personId", messageSource.getMessage("non.unique.personId", new String[]{user.getPersonId()}, Locale.getDefault()));
            result.addError(personIdError);
            return "bcsp/usersregistration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "User " + user.getFullName() + " " + user.getMobileNumber() + " registered successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "bcsp/registrationsuccess";
    }


    @RequestMapping(value = {"/edit-user-{personId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String personId, ModelMap model) {
        User user = userService.findByPERSONID(personId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "bcsp/usersregistration";
    }

    @RequestMapping(value = {"/edit-user-{personId}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
                             ModelMap model, @PathVariable String personId) {

        if (result.hasErrors()) {
            return "bcsp/usersregistration";
        }
        userService.updateUser(user);
        model.addAttribute("success", "User " + user.getFullName() + " " + user.getMobileNumber() + " updated successfully");
        model.addAttribute("loggedinuser", getPrincipal());
        return "bcsp/registrationsuccess";
    }

    @RequestMapping(value = {"/delete-user-{pid}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String pid) {
        userService.deleteUserByPERSONID(pid);
        return "redirect:/userslist";
    }

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "bcsp/accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "bcsp/login";
        } else {
            return "redirect:/userslist";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            //new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    //Dimensions


    @RequestMapping(value = {"/xxx"}, method = RequestMethod.GET)
    public String slidesDimension(ModelMap model) {

        //string[] filePaths = Directory.GetFiles(Server.MapPath("~/assets/img/"));
        //List<Slider> files = new List<Slider>();
        //foreach (string filePath in filePaths)
        //{
        //	string fileName = Path.GetFileName(filePath);
        //	files.Add(new Slider{
        //	title= fileName.Split('.')[0].ToString(),
        //			src = "../assets/img/" + fileName
        //});
        //}

        List<Dimensions> dimensions = dimensionsService.findAllDimensions();
        model.addAttribute("dimensions", dimensions);
        return "bcsp/dimensionslist";
    }


    @RequestMapping(value = {"/dimensionslist"}, method = RequestMethod.GET)
    public String listDimensionstest(ModelMap model) {

        List<Dimensions> dimensions = dimensionsService.findAllDimensions();
        model.addAttribute("dimensions", dimensions);
        return "bcsp/dimensionslist";
    }

    @RequestMapping(value = {"/dimImage"}, method = RequestMethod.GET)
    public void productImage(HttpServletRequest request, HttpServletResponse response, ModelMap model,
                             @RequestParam("code") String code) throws IOException {
        Dimensions dimensions = null;
        if (code != null) {
            dimensions = this.dimensionsService.findByDID(code);
        }
        if (dimensions != null && dimensions.getData() != null) {
            response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
            response.getOutputStream().write(dimensions.getData());
        }
        response.getOutputStream().close();
    }


    @RequestMapping(value = {"/dimensionslistnnnn"}, method = RequestMethod.GET)
    public String listDimensions(ModelMap model) {

        List<Dimensions> dimensions = dimensionsService.findAllDimensions();
        model.addAttribute("dimensions", dimensions);
        return "bcsp/dimensionslist";
    }

	/*

	@RequestMapping(value = {"/dimensionsreview"}, method = RequestMethod.GET)
	public String Reviewdimensions(ModelMap model, @PathVariable int control, int meaning, int exposure, int encouragement, int timing, int empathy, int obtrusiveness, int importance, int direction ) {
  	    List<Dimensions>dimensions=dimensionsService.findDimensionsByValues(control, meaning, exposure, encouragement, timing, empathy, obtrusiveness,importance, direction);
		model.addAttribute("dimensions", dimensions);
		model.addAttribute("edit", false);
		return "fragments/sidebar";
	}

	*/

    @RequestMapping(value = {"/newdimension"}, method = RequestMethod.GET)
    public String newPatient(ModelMap model) {
        Dimensions dimensions = new Dimensions();
        populateDefaultModelp(model);
        model.addAttribute("dimensions", dimensions);
        model.addAttribute("edit", false);
        return "bcsp/dimensionsregestration";
    }

    public File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    @RequestMapping(value = {"/toolsReview"}, method = RequestMethod.POST)
    public String toolsReview(ModelMap model,@RequestParam("dControl") int dControl,
                                             @RequestParam("dMeaning") int dMeaning,
                                             @RequestParam("dExposure") int dExposure,
                                             @RequestParam("dEncouragement") int dEncouragement,
                                             @RequestParam("dTiming") int dTiming,
                                             @RequestParam("dEmpathy") int dEmpathy,
                                             @RequestParam("dObtrusiveness") int dObtrusiveness,
                                             @RequestParam("dImportance") int dImportance,
                                             @RequestParam("dDirection") int dDirection
                                                ) throws IOException {

       // if (result.hasErrors()) {
         //   populateDefaultModelp(model);
           // return "bcsp/index";
        //}

        //List<Dimensions> dimensions1= dimensionsService.review(dimensions.getdControl(),dimensions.getdMeaning(),dimensions.getdExposure(),dimensions.getdEncouragement(),dimensions.getdTiming(),dimensions.getdEmpathy(), dimensions.getdObtrusiveness(), dimensions.getdImportance(), dimensions.getdDirection());



        List<Dimensions> dimensions= dimensionsService.review(dControl, dMeaning,dExposure,dEncouragement,dTiming,dEmpathy,dObtrusiveness, dImportance, dDirection);
        //populateDefaultModelp(model);
        model.addAttribute("dimensions", dimensions);
        return "bcsp/review";
    }
    //
    //@PathVariable int dControl, int dMeaning, int dExposure, int dEncouragement, int dTiming, int dEmpathy, int dObtrusiveness, int dImportance, int dDirection,



    @RequestMapping(value = {"/toolsReview"}, method = RequestMethod.GET)
    public String toolsReviewQuery(ModelMap model,@RequestParam("dControl") int dControl) throws IOException {

        List<Dimensions> dimensions= dimensionsService.review(3,2,3,4,5,6,7, 8, 9);
        model.addAttribute("dimensions", dimensions);
        return "bcsp/review";
    }
// @RequestParam("dControl")Integer dControl,@RequestParam("dMeaning")Integer dMeaning,@RequestParam("dExposure")Integer dExposure,
//                         @RequestParam("dEncouragement")Integer dEncouragement,@RequestParam("dTiming")Integer dTiming,
//                         @RequestParam("dEmpathy")Integer dEmpathy,@RequestParam("dObtrusiveness")Integer dObtrusiveness,
//                         @RequestParam("dImportance")Integer dImportance,@RequestParam("dDirection")Integer dDirection


    //
    private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }



    //
    @RequestMapping(value = {"/newdimension"}, method = RequestMethod.POST)
    public String saveDimension(@Valid Dimensions dimensions, BindingResult result,
                                ModelMap model,  @RequestParam("photo") MultipartFile photo) throws IOException {

        if (result.hasErrors()) {
            populateDefaultModelp(model);
            return "bcsp/dimensionsregestration";
        }
        //Image re=resize((BufferedImage) photo,4,4);

        if(photo.isEmpty() || photo.getSize()==0){
            //errors.rejectValue("file", "Please select a file");
            return "bcsp/dimensionsregestration";
        }


        if(!(photo.getContentType().toLowerCase().equals("image/jpg")
                || photo.getContentType().toLowerCase().equals("image/jpeg")
                || photo.getContentType().toLowerCase().equals("image/png"))){
            //errors.re
            //FieldError pidError = new FieldError("dimensions", "photo", messageSource.getMessage("jpg/png images are only supported", new String[]{dimensions.getDimensionId()}, Locale.getDefault()));
            //result.addError(jpg/png file types are only supported");

           //errors.rejectValue("file", "jpg/png file types are only supported");
            return "bcsp/dimensionsregestration";
        }



        if (!dimensionsService.isDimensionDIDUnique(dimensions.getId(), dimensions.getDimensionId())) {
            FieldError pidError = new FieldError("dimensions", "dimensionId", messageSource.getMessage("non.unique.dimensionId", new String[]{dimensions.getDimensionId()}, Locale.getDefault()));
            result.addError(pidError);
            return "bcsp/dimensionsregestration";
        }

        populateDefaultModelp(model);

        //
        //File input = new File(String.valueOf(photo));
        //BufferedImage image = ImageIO.read(input);
        //BufferedImage resized = resize(image, 500, 500);
        //ImageIO.write(resized, "png", (ImageOutputStream) resized);

        //
        //dimensionsService.saveDimensions(dimensions);
        dimensionsService.insert(dimensions, photo);
        //
        populateDefaultModelp(model);
        model.addAttribute("dimensions", dimensions);
        model.addAttribute("success", "The tool  " + dimensions.getDimensionId() + " registered successfully");
        //return "success";

        return "bcsp/dimensionregistrationsuccess";
    }
    //
    @RequestMapping(value = {"/edit-dimension-{did}"}, method = RequestMethod.GET)
    public String editDimension(@PathVariable String did, ModelMap model) {
        Dimensions dimensions = dimensionsService.findByDID(did);
        populateDefaultModelp(model);
        model.addAttribute("dimensions", dimensions);
        model.addAttribute("edit", true);
        return "bcsp/dimensionsregestration";
    }

    @RequestMapping(value = {"/edit-dimension-{dimensionId}"}, method = RequestMethod.POST)
    public String updateDimension(@Valid Dimensions dimensions, BindingResult result,
                                  ModelMap model,  @RequestParam("photo") MultipartFile photo) throws IOException {

        if (result.hasErrors()) {
            return "bcsp/dimensionsregestration";
        }
        if(!(photo.getContentType().toLowerCase().equals("image/jpg")
                || photo.getContentType().toLowerCase().equals("image/jpeg")
                || photo.getContentType().toLowerCase().equals("image/png"))){
            //errors.re
            //FieldError pidError = new FieldError("dimensions", "photo", messageSource.getMessage("jpg/png images are only supported", new String[]{dimensions.getDimensionId()}, Locale.getDefault()));
            //result.addError(jpg/png file types are only supported");

            //errors.rejectValue("file", "jpg/png file types are only supported");
            return "bcsp/dimensionsregestration";
        }

        //dimensionsService.updateDimensions(dimensions);
        dimensionsService.updateDimensions(dimensions, photo);

        model.addAttribute("success", "Dimensions " + dimensions.getName() + " " + dimensions.getDimensionId() + " updated successfully");
        return "bcsp/dimensionregistrationsuccess";
    }


    @RequestMapping(value = {"/delete-dimension-{did}"}, method = RequestMethod.GET)
    public String deleteDimension(@PathVariable String did) {
        dimensionsService.deleteDimensionsByDID(did);
        return "redirect:/dimensionslist";
    }


    @RequestMapping(value = {"/add-document-{dimensionId}"}, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int dimensionId, ModelMap model) {
        Dimensions dimensions = dimensionsService.findById(dimensionId);
        model.addAttribute("dimensions", dimensions);

        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
        List<DimensionsDocument> documents = dimensionsDocumentService.findAllByDimensionId(dimensionId);
        model.addAttribute("documents", documents);
        return "bcsp/dimensionmanagedocuments";
    }


    @RequestMapping(value = {"/download-document-{dimensionId}-{docId}"}, method = RequestMethod.GET)
    public String downloadDocument(@PathVariable int dimensionId, @PathVariable int docId, HttpServletResponse response) throws IOException {
        DimensionsDocument document = dimensionsDocumentService.findById(docId);
        response.setContentType(document.getType());
        response.setContentLength(document.getContent().length);
        response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getName() + "\"");

        FileCopyUtils.copy(document.getContent(), response.getOutputStream());

        return "redirect:/add-document-" + dimensionId;
    }

    @RequestMapping(value = {"/delete-document-{dimensionId}-{docId}"}, method = RequestMethod.GET)
    public String deleteDocument(@PathVariable int dimensionId, @PathVariable int docId) {
        dimensionsDocumentService.deleteById(docId);
        return "redirect:/add-document-" + dimensionId;
    }

    @RequestMapping(value = {"/add-document-{dimensionId}"}, method = RequestMethod.POST)
    public String uploadDocument(@Valid FileBucket fileBucket, BindingResult result, ModelMap model, @PathVariable int dimensionId) throws IOException {

        if (result.hasErrors()) {
            System.out.println("validation errors");
            Dimensions dimensions = dimensionsService.findById(dimensionId);
            model.addAttribute("dimensions", dimensions);

            List<DimensionsDocument> documents = dimensionsDocumentService.findAllByDimensionId(dimensionId);
            model.addAttribute("documents", documents);
            return "bcsp/dimensionmanagedocuments";
        } else {

            System.out.println("Fetching file");

            Dimensions dimensions = dimensionsService.findById(dimensionId);
            model.addAttribute("dimensions", dimensions);

            saveDocument(fileBucket, dimensions);

            return "redirect:/add-document-" + dimensionId;
        }
    }

    private void saveDocument(FileBucket fileBucket, Dimensions dimensions) throws IOException {

        DimensionsDocument document = new DimensionsDocument();

        MultipartFile multipartFile = fileBucket.getFile();

        document.setName(multipartFile.getOriginalFilename());
        document.setDescription(fileBucket.getDescription());
        document.setType(multipartFile.getContentType());
        document.setContent(multipartFile.getBytes());
        document.setDimensions(dimensions);
        dimensionsDocumentService.saveDocument(document);
    }


    //////
    // GET: Show product.
    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public String product(Model model, @RequestParam(value = "code", defaultValue = "") String code) {
        Dimensions dimensions = null;

        //if (code != null && code.length() > 0) {
        //	productInfo = productDAO.findProductInfo(code);
        //}
        if (dimensions == null) {
            dimensions = new Dimensions();
            //dimensions.setNewProduct(true);
        }
        model.addAttribute("productForm", dimensions);
        return "product";
    }


    // POST: Save product
    @RequestMapping(value = {"/product"}, method = RequestMethod.POST)
    // Avoid UnexpectedRollbackException (See more explanations)
    @Transactional(propagation = Propagation.NEVER)
    public String productSave(Model model, //
                              @ModelAttribute("productForm") @Validated Dimensions dimensions, //
                              BindingResult result, //
                              final RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            return "product";
        }
        try {
            dimensionsService.saveDimensions(dimensions);
        } catch (Exception e) {
            // Need: Propagation.NEVER?
            String message = e.getMessage();
            model.addAttribute("message", message);
            // Show product form.
            return "product";

        }
        return "redirect:/product";
    }
}


