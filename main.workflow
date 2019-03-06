workflow "when I push" {
  on = "push"
  resolves = "ci"
}

action "ci" {
  uses = "docker://golang:latest"
  runs = "./script/cibuild"
}
