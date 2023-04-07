<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sobre nós - HealthTech</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="styles.css" type="text/css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
        .container{
            font-family: "Roboto Thin",sans-serif;
        }

    </style>

</head>

<body>

<c:import url="menu.jsp" />

<main>
    <div class="container">
        <h1 class="text-center my-5">HeathTech: Tecnologia à serviço da saúde!</h1>
        <p>Somos uma empresa de equipamentos médicos comprometida em fornecer soluções inovadoras e de alta qualidade para ajudar profissionais médicos a melhorar a saúde de seus pacientes. Com anos de experiência no mercado, temos o conhecimento e a experiência necessários para oferecer os melhores produtos e serviços em nosso setor.</p>
        <p>Nossa equipe é composta por profissionais altamente qualificados e experientes em várias áreas, incluindo engenharia, design, fabricação, vendas e suporte ao cliente. Trabalhamos juntos para garantir que cada produto que oferecemos atenda às necessidades de nossos clientes e ajude a melhorar a qualidade dos cuidados médicos.</p>
        <p>Nosso catálogo de produtos inclui uma ampla variedade de equipamentos médicos, desde dispositivos de diagnóstico até soluções de terapia e monitoramento de pacientes. Todos os nossos produtos são projetados para atender aos mais altos padrões de qualidade e segurança, e são testados rigorosamente antes de serem disponibilizados para venda.</p>
        <p>Além disso, estamos empenhados em fornecer um serviço excepcional ao cliente. Temos uma equipe dedicada de especialistas prontos para ajudar nossos clientes a escolher o produto certo para suas necessidades, além de oferecer suporte técnico e assistência pós-venda para garantir que nossos produtos funcionem de forma eficaz e eficiente.</p>
        <p>Estamos orgulhosos de ser uma empresa de equipamentos médicos confiável e respeitada, com uma reputação sólida por fornecer produtos e serviços de qualidade a nossos clientes. Nosso compromisso com a inovação, qualidade e atendimento ao cliente continuará a impulsionar nosso sucesso e crescimento no futuro.</p>
    </div>

    <div class="container">
        <h2>Visão:</h2>
        <p>Ser a líder no mercado de equipamentos médicos, oferecendo soluções inovadoras e de alta qualidade que atendam às necessidades de nossos clientes, melhorando a saúde e o bem-estar das pessoas em todo o mundo.</p>
        <br>
        <h2>Valores:</h2>
        <ul>
            <li>Inovação: buscamos sempre novas ideias e tecnologias para criar soluções inovadoras que atendam às necessidades em constante evolução dos profissionais médicos e pacientes.</li>
            <li>Qualidade: comprometemo-nos a fornecer produtos e serviços de alta qualidade que atendam ou superem os mais altos padrões do setor.</li>
            <li>Integridade: trabalhamos com honestidade, ética e transparência em todas as nossas operações e relacionamentos comerciais.</li>
            <li>Colaboração: valorizamos o trabalho em equipe e colaboramos para alcançar objetivos comuns, tanto internamente quanto com nossos clientes e parceiros.</li>
            <li>Compromisso com o cliente: colocamos nossos clientes em primeiro lugar e nos esforçamos para atender às suas necessidades e expectativas com excelência em produtos e serviços.</li>
        </ul>
     <br>
        <h2>Missão:</h2>
        <p>Fornecer soluções inovadoras e de alta qualidade em equipamentos médicos, ajudando os profissionais de saúde a melhorar a saúde e o bem-estar de seus pacientes. Nosso compromisso com a excelência em produtos e serviços nos torna uma empresa confiável e respeitada no mercado, garantindo que nossos clientes recebam os melhores equipamentos e suporte técnico para ajudá-los a alcançar seus objetivos clínicos. Trabalhamos com integridade e transparência em todas as nossas operações, valorizando nossos clientes, colaboradores e parceiros comerciais.</p>
    </div>
</main>

<c:import url="footer.jsp" />

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(window).on('load', function() {
        $('main').fadeIn('slow');
    });
</script>
<!-- Importando os arquivos JS do Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"></script>


</body>
</html>