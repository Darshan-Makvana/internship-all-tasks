function showProject(projectId) {
    const projectDetails = document.querySelectorAll('.project-details');
    projectDetails.forEach((project) => {
        project.style.display = 'none';
    });

    const selectedProject = document.getElementById(projectId);
    selectedProject.style.display = 'block';
}
